import { DAORecetas } from './DAORecetas.js';

export class recetasController {
    static getRecetas = async (req, res) => {
        try {
            // const { user } = req.session;
            // return res.json({ user });
            // if (!user) return res.status(401).json({ message: 'No autorizado' });
            const data = await DAORecetas.selectAll();
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }

    static selectByUserID = async (req, res) => {
        try {
            const { id } = req.params;
            // if (!user) return res.status(401).json({ user: null });
            const data = await DAORecetas.selectByUserID(id);
            return res.status(200).json(data);
        } catch (e) {
            return res.status(400).json(e);
        }
    }
    static selectByID = async (req, res) => {
        try {
            const { id } = req.params;
            // if (!user) return res.status(401).json({ user: null });
            const data = await DAORecetas.selectByID(id);
            return res.status(200).json({status: true, data:data});
        } catch (e) {
            return res.status(400).json(e);
        }
    }
}