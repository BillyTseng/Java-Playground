package come.SystemDesign_I.InMemoryFileSystem;

public class File extends Entry{
    private String contents;
    private int size;

    public File(String n, Directory p, int sz) {
        super(n, p);
        size = sz;
    }

    @Override
    public int size() {
        return size;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
