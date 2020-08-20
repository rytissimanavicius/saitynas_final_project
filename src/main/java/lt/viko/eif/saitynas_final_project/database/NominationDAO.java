package lt.viko.eif.saitynas_final_project.database;

import lt.viko.eif.saitynas_final_project.objects.Nomination;

public interface NominationDAO {
	public int addNomination(Nomination nomination);
	public int deleteNominationById(int id);
	public int updateNominationById(Nomination nomination);
	public Nomination getNominationById(int id);
}
