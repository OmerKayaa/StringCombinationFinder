package Controller;

import Model.QueryType;

import java.nio.file.Path;
import java.util.function.Consumer;

public class ParallelSearch extends Thread implements Search
{
    private final Consumer<String> consumer;
    private final QueryType type;
    private final String query;
    private final Path file;

    public ParallelSearch(Path file,
                          QueryType type, String query, Consumer<String> consumer)
    {
        this.consumer = consumer;
        this.query = query;
        this.type = type;
        this.file = file;

    }

    @Override
    public void run()
    {
        Search.Find(file,type,query,consumer);
    }
}
