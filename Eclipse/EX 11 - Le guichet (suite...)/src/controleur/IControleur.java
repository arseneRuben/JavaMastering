package controleur;

import modele.ICompte;
import vue.IVue;

public interface IControleur {

	void setVue(IVue uneVue);

	void setCompte(ICompte unCompte);

	double getSolde();

	void action();

}