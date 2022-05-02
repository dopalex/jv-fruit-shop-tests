package core.basesyntax.service.read;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class ReaderServiceTest {
    private static ReaderService readerService;
    private static final String VALID_DATA_PATH = "src/test/java/resources/validData.csv";
    private static final String INCORRECT_PATH = "src/test/java/validData.csv";

    @BeforeClass
    public static void beforeClass() {
        readerService = new ReaderServiceImpl();
    }

    @Test
    public void read_readInput_Ok() {
        List<String> expected = List.of(
                "type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100");

        List<String> actual = readerService.read(VALID_DATA_PATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void read_incorrectPath_NotOk() {
        readerService.read(INCORRECT_PATH);
    }

    @Test(expected = NullPointerException.class)
    public void read_NullPath_NotOk() {
        readerService.read(null);
    }
}
