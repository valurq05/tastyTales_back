import pool from '../../database.js'

export class DAOauth {

    static login = async (user) => {
        try {
            const [[data]] = await pool.query('SELECT * FROM usuarios WHERE userNombre = ?',
                [user.userNombre]);
            return data;
        } catch (e) {
            return { message: e.message };
        }
    }

    static validExists = async (user) => {
        try {
            const [[usuario]] = await pool.query('SELECT * FROM usuarios WHERE userNombre = ?',
                [user]);
            const data = (usuario) ? 1 : 0;
            return data;
        } catch (e) {
            return { message: e.message };
        }
    }
    
}