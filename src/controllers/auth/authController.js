import { DAOauth } from './DAOAuth.js';
import { DTOauth } from './DTOAuth.js';
import bcrypt from 'bcrypt';
import jwt from 'jsonwebtoken';
import { validation } from '../../validations.js';
import { SECRET_JWT_KEY } from '../../config.js';

export class authController {
    static loginUser = async (req, res) => {
        try {
            const { userNombre, userPassword } = req.body;
            const user = { userNombre, userPassword }
            // return res.json(user);
            // Validación usuario
            validation.usermail(userNombre);
            // Validación contraseña
            validation.password(userPassword);

            // Validar que el usuario exista 
            const userDB = await DAOauth.login(user);
            // return res.json(userDB);
            if (!userDB) throw new Error('Usuario no encontrado.');
            const isValidPass = await bcrypt.compare(userPassword, userDB.userPassword);
            if (!isValidPass) throw new Error('Contraseña incorrecta.');
            const token = jwt.sign(
                {userID: userDB.userID, usermail:userNombre, user:userDB.userNombre}, 
                SECRET_JWT_KEY, 
                {expiresIn: '1h'}
            );
            res
            .cookie('access_token', token,{
                httpOnly: true,
                // secure: true,
                sameSite: 'strict',
                maxAge: 1000 * 60 * 60
            })
            .send({
                data: {
                    user: userDB.userNombre,
                    token: token
                }
            });

        } catch (e) {
            return res.status(401).json({ message: e.message });
        }
    }

    static registerUser = async (req, res) => {
        try {
            const { userNombre, userPassword, userDoc } = req.body;
            const user = { userNombre, userPassword, userDoc }
            // return res.json(user);

            // Validación usuario
            validation.usermail(userNombre);

            // Validación contraseña
            validation.password(userPassword);

            const userDB = await DAOauth.validExists(userNombre);
            if (userDB === 1) throw new Error('El usuario ya existe.');
            const hashedPassword = await bcrypt.hash(userPassword, 10);
            // return res.json(hashedPassword);
            const registro = await DTOauth.register({ user, password: hashedPassword });
            
            // const token = jwt.sign(
            //     {usermail:userNombre, user: userPassword, rol:userDoc}, 
            //     SECRET_JWT_KEY, 
            //     {expiresIn: '1h'}
            // );
            // res
            // .cookie('access_token', token,{
            //     httpOnly: true,
            //     // secure: true,
            //     sameSite: 'strict',
            //     maxAge: 1000 * 60 * 60
            // })
            // .send({registro, token});
            return res.status(200).json(registro);
            // const crypto = criptoJS.AES.encrypt('Uniempresarial1*', keyPassword).toString();

        } catch (e) {
            return res.status(400).json({ message: e.message });
        }
    }
    static logout = async (req, res) => {
        try {
            res
            .clearCookie('access_token')
            .send({message: 'Sesión cerrada.'});
        } catch (e) {
            return res.status(400).json({ message: e.message });
        }
    }

}
