package lt.viko.eif.saitynas_final_project.database;

import lt.viko.eif.saitynas_final_project.objects.Genre;

public interface GenreDAO {
	public int addGenre(Genre genre);
	public int deleteGenreById(int id);
	public int updateGenreById(Genre genre);
	public Genre getGenreById(int id);
}