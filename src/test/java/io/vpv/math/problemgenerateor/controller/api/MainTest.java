package io.vpv.math.problemgenerateor.controller.api;

import io.vpv.math.problemgenerateor.ProblemGenerateorApplication;
import org.junit.Test;

/**
 * Created by vprasanna on 2/12/19.
 */

public class MainTest {
    @Test
    public void main() {
        System.setProperty("server.port", "8181");
        ProblemGenerateorApplication.main(new String[]{});
    }
}
