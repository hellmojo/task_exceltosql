import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import db.DBAction;
import model.Task;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {


        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().headerCount(2).build();
        List<Task> actualTask = Poiji.fromExcel(new File("./data/task.xlsx"), Task.class, options);
        actualTask.remove(0);
       // DBAction.makeTable();
       // DBAction.fillTable(actualTask);
        DBAction.totalSum();


    }
}
