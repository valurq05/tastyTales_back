import pool from '../../database.js'

export class DAOAdicionales {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT a.adicionalID, a.adDescripcion FROM adicionales a');
        return data;
    }

    static selectByID = async (id) => {
        const [[data]] = await pool.query('SELECT a.adicionalID, a.adDescripcion FROM adicionales a' + ' ' + 
            'WHERE a.adicionalID = ?', id);
        return data;
    }
}

