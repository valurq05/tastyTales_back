import pool from '../../database.js'

export class DTOAdicionales {
    static insert = async (data) => {
        // return data.adDescription;
        await pool.query('INSERT INTO adicionales (adDescripcion)'+ ' ' +
            'VALUES (?)', data.adDescription);
            return {message: 'adicional creado exitosamente', data:data};
    }
}