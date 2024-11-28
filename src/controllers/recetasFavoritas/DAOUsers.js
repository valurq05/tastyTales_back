import pool from '../../database.js'

export class DAOUsers {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT *' + ' ' +
            'FROM usuarios AS u' + ' ' +
            '');
        return data;
    }

    static selectByID = async (id) => {
        const [[data]] = await pool.query('SELECT u.userID, u.userNombre' + ' ' +
            'FROM usuarios AS u' + ' ' +
            'WHERE u.userID = ?', id);
        return data;
    }
}

