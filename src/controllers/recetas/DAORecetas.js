import pool from '../../database.js'

export class DAORecetas {
    static selectAll = async () => {
        const [data] = await pool.query('SELECT *' + ' ' +
            'FROM recetas AS r' + ' ' +
            '');
        const [calif] = await pool.query('SELECT AVG(c.calificacion) AS calificacion, c.recetaID' + ' ' +
            'FROM calificacionRecetas AS c' + ' ' +
            'GROUP BY c.recetaID');
        return {data, calif};
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

