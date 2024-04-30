package Project_102873_125511_120441_aed2_lp2_202324;

public interface DBManageAuthorsI {
    public Author addAuthor(Author author);
    public Author getAuthor(int cienciaID);
    public Author removeAuthor(Author author);
    public Author listAuthors();
    public void archiveAuthor(String data);
    }
