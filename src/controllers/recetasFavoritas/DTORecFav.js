import pool from '../../database.js'

export class DTORecFav {

    static createFavRecipe = async (data) => {
        await pool.query(`INSERT INTO recetasfavoritas(recFavStatus, userID, recetaID) VALUES (1,?,?)`, [data.userID, data.recetaID]);
        return {status:true, message: 'Receta favorita creada exitosamente.'};
    }
}

