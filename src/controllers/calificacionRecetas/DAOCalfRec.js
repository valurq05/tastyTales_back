import pool from '../../database.js'

export class DAOCalfRec {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT cr.calificacion, u.userID, u.userNombre, r.recetaID, r.recetaTitulo' + ' ' +
            'FROM calificacionrecetas cr' + ' ' +
            'INNER JOIN recetasusuarios ru ON ru.recUserID = cr.recUserID' + ' ' +
            'INNER JOIN usuarios u ON u.userID = ru.userID' + ' ' +
            'INNER JOIN recetas r ON r.recetaID = ru.recetaID'
        );
        return data;
    }

    static selectByID = async (id) => {
        const [[data]] = await pool.query('SELECT cr.calificacion, u.userID, u.userNombre, r.recetaID, r.recetaTitulo' + ' ' +
            'FROM calificacionrecetas cr' + ' ' +
            'INNER JOIN recetasusuarios ru ON ru.recUserID = cr.recUserID' + ' ' +
            'INNER JOIN usuarios u ON u.userID = ru.userID' + ' ' +
            'INNER JOIN recetas r ON r.recetaID = ru.recetaID' + ' ' +
            'WHERE userID = ?', id);
        return data;
    }
}

