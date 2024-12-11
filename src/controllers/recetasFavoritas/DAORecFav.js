import pool from '../../database.js'

export class DAORecFav {
    // static selectAll = async () => {
    //     const [data] = await pool.query('SELECT *' + ' ' +
    //         'FROM recetasFavoritas AS u' + ' ' +
    //         '');
    //     return data;
    // }

    static selectByIDUser = async (id) => {
        const [data] = await pool.query(`SELECT rf.recFavID, rf.userID, rf.recetaID, 
            u.userNombre, 
            p.perName, p.perLastName, 
            r.recetaTitulo, r.recetaDescripcion, r.recetaStatus 
            FROM recetasFavoritas AS rf
            INNER JOIN usuarios AS u ON u.userID = rf.userID
            INNER JOIN personas AS p ON p.userID = u.userID
            INNER JOIN recetas AS r ON r.recetaID = rf.recetaID
            WHERE u.userID = ?`, [id]);
        return data;
    }
}

