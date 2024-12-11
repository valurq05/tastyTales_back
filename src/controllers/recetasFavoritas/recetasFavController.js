import { DAORecFav } from './DAORecFav.js';

export class recetasFavController {
    static getRecetasFavoritas = async (req, res) => {
        try {
            const { id } = req.params;
            // return res.json({ user });
            // if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DAORecFav.selectByIDUser(id);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }

    // static selectByID = async (req, res) => {
    //     try {
    //         const { user } = req.session;
    //         if (!user) return res.status(401).json({ user: null });
    //         const data = await DAOUsers.selectByID(user.userID);
    //         return res.status(200).json(data);
    //     } catch (e) {
    //         return res.status(400).json(e);
    //     }
    // }
}