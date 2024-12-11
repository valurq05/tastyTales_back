import pool from '../../database.js'

export class DAOCalfRec {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT cr.calificacion, u.userID, u.userNombre, r.recetaID, r.recetaTitulo' + ' ' +
            'FROM calificacionrecetas cr' + ' ' +
            'INNER JOIN usuarios u ON u.userID = cr.userID' + ' ' +
            'INNER JOIN recetas r ON r.recetaID = cr.recetaID'
        );
        return data;
    }

    static selectByID = async (id) => {
        const [[data]] = await pool.query('SELECT cr.calificacion, u.userID, u.userNombre, r.recetaID, r.recetaTitulo' + ' ' +
            'FROM calificacionrecetas cr' + ' ' +
            'INNER JOIN usuarios u ON u.userID = cr.userID' + ' ' +
            'INNER JOIN recetas r ON r.recetaID = cr.recetaID' + ' ' +
            'WHERE cr.userID = ?', id);
        return data;
    }
}

