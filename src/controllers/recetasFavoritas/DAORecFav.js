import pool from '../../database.js'

export class DAORecFav {
    // static selectAll = async () => {
    //     const [data] = await pool.query('SELECT *' + ' ' +
    //         'FROM recetasFavoritas AS u' + ' ' +
    //         '');
    //     return data;
    // }

    static selectByIDUser = async (id) => {
        const [[data]] = await pool.query('SELECT u.userID, u.userNombre' + ' ' +
            'FROM recetasFavoritas AS u' + ' ' +
            'WHERE u.userID = ?', id);
        return data;
    }
}

