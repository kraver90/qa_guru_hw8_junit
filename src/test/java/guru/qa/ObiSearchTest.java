package guru.qa;

import guru.qa.pages.ObiSearch;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;


public class ObiSearchTest extends TestBase {

    ObiSearch obiSearch = new ObiSearch();


    @ValueSource(strings = {"Плитка", "Ламинат"})
    @Tag("blocker")
    @DisplayName("Поиск каталогов на сайте Obi")
    @ParameterizedTest(name = "Поиск на сайте Obi каталог {0}")
    void obiSearchTest(String searchCatalog) {
        obiSearch
                .openPage()
                .typeSearch(searchCatalog)
                .checkResultCatalog(searchCatalog);
    }


    @CsvSource(value = {
            "Плитка| Плитка",
            "Ламинат| Ламинат",
            "Kfvgs| Лампочки и ламповые патроны"
    },
            delimiter = '|')
    @Tag("blocker")
    @DisplayName("Поиск каталогов на сайте Obi")
    @ParameterizedTest(name = "Поиск на сайте Obi каталог {0} и проверка отображения каталогов {1}")
    void obiSearchTest(String searchCatalog, String expectedResult) {
        obiSearch
                .openPage()
                .typeSearch(searchCatalog)
                .checkResultCatalog(expectedResult);
    }


    static Stream<Arguments> obiSearchTestMethod() {
        return Stream.of(
                Arguments.of("Плитка", "Плитка"),
                Arguments.of("Ламинат", "Ламинат"),
                Arguments.of("Лампы", "Лампочки и ламповые патроны")
        );
    }

    @MethodSource
    @Tag("blocker")
    @DisplayName("Поиск каталогов на сайте Obi")
    @ParameterizedTest(name = "Поиск на сайте Obi каталог {0} и проверка отображения каталогов {1}")
    void obiSearchTestMethod(String searchCatalog, String expectedResult) {
        obiSearch
                .openPage()
                .typeSearch(searchCatalog)
                .checkResultCatalog(expectedResult);
    }

}
