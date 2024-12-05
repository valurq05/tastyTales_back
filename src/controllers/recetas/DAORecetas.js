import pool from '../../database.js'

export class DAORecetas {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            '');
        return data;
    }

    static selectByID = async (id) => {
        const [[data]] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            'WHERE r.recetaID = ?', id);
        return data;
    }

    static selectByUserID = async (id) => {
        const [data] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            'WHERE r.userID = ?', id);
        return data;
    }
}

