import pool from '../../database.js'

export class DAOUsers {
    static selectAll = async () => {
        const [users] = await pool.query('SELECT *' + ' ' +
            'FROM usuarios AS u');
        const [persons] = await pool.query('SELECT *' + ' ' +
            'FROM personas AS p');
            
        for (let i = 0; i < users.length; i++) {
            for (let f = 0; f < persons.length; f++) {
                if (users[i].userID === persons[f].userID) {
                    users[i].person = persons[f];
                    break;
                }
            }
        }
        return users;
    }

    static selectByID = async (data) => {
        const [[user]] = await pool.query('SELECT *' + ' ' +
            'FROM usuarios AS u'+ ' ' +
            'WHERE u.userID = ?', data.userID);
        const [[person]] = await pool.query('SELECT *' + ' ' +
            'FROM personas AS p' + ' ' +
            'WHERE P.userID = ?', id);

        user.person = person;
        return user;
    }
}

