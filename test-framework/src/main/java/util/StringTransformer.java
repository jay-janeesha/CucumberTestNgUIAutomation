package util;

import cucumber.api.DataTable;
import cucumber.api.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTransformer extends Transformer<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringTransformer.class);
    private static final Map<String, String> RANDOM_STRINGS = new HashMap<>();   //Key -> random string
    public static final StringTransformer INSTANCE = new StringTransformer();

    @Override
    public String transform(String input) {
        return transformString(input);
    }

    public DataTable transform(DataTable dataTable) {
        dataTable.getGherkinRows().forEach(dataTableRow -> dataTableRow.getCells().replaceAll(this::transformString));
        return dataTable;
    }

    /**
     * This method is used to create a random string and date
     * @param input
     * @return
     */
    private String transformString(String input) {
        final String[] inputCopy = {input};
        Map<String, String> replacements = new HashMap<>();
        Matcher matcher = Pattern.compile("(<random_*_[^>]*>)").matcher(input);
        while (matcher.find()) {
            String group = matcher.group(0);
            if (group.contains("<random_string")) {
                replacements.put(group, RANDOM_STRINGS.computeIfAbsent(group, key -> Utilities.getNextUniqueString()));
            } else if (group.contains("<random_date")) {
                replacements.put(group, RANDOM_STRINGS.computeIfAbsent(group, key -> Utilities.generateRandomDate(-50)));
            } else {
                Assert.fail("Invalid string is passed to create random value");
            }
        }
        replacements.forEach((key, value) -> inputCopy[0] = inputCopy[0].replace(key, value));
        return inputCopy[0];
    }
}
