import { DAOUsers } from './DAOUsers.js';

export class userController {
    static getUsers = async (req, res) => {
        try {
            const { user } = req.session;
            // return res.json({ user });
            // if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DAOUsers.selectAll();
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }

    static selectByID = async (req, res) => {
        try {
            const { user } = req.session;
            if (!user) return res.status(401).json({ message: 'No hay sesion activa.'});
            const data = await DAOUsers.selectByID(user);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }
}