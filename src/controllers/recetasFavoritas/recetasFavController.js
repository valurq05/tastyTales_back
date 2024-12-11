import { DAORecFav } from './DAORecFav.js';
import { DTORecFav } from './DTORecFav.js';

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

    static postRecetasFavoritas = async (req, res) => {
        try {
            const { body } = req;
            // if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DTORecFav.createFavRecipe(body);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }
}