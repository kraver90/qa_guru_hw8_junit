package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ObiSearch {

    public static String OBI_PAGE = "https://www.obi.ru/";

    private SelenideElement
            searchInput = $(".headr__search-input"),
            resultTable = $(".block-context");


    public ObiSearch openPage() {
        open(OBI_PAGE);
        return this;
    }

    public ObiSearch typeSearch(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public ObiSearch checkResultCatalog(String value) {
        resultTable.scrollTo().shouldHave(text(value));
        return this;
    }
}
