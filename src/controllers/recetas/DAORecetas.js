import pool from '../../database.js'

export class DAORecetas {
    static selectAll = async () => {
        const [data] = await pool.query(`
            SELECT r.recetaID, r.recetaTitulo, r.recetaDescripcion, r.recetaStatus, r.userID, 
                AVG(c.calificacion) AS calificacion
            FROM recetas AS r 
            INNER JOIN calificacionRecetas AS c ON c.recetaID = r.recetaID 
            GROUP BY 
                r.recetaID, 
                r.recetaTitulo, 
                r.recetaDescripcion, 
                r.recetaStatus, 
                r.userID
        `);
        return data;
    
    }

    static selectByID = async (id) => {

        const [[recipe]] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            'WHERE r.userID = ?', id);
            
        const [steps] = await pool.query('SELECT p.pasoTitulo, p.pasoDescripcion, p.recetaID' + ' ' +
                'FROM pasos AS p' + ' ' +
                'WHERE p.recetaID = ?', recipe.recetaID);
        return {recipe, steps};
    }

    static selectByUserID = async (id) => {
        const [data] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            'WHERE r.userID = ?', id);
        return data;
    }
}

