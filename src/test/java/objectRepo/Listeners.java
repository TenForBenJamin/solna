package objectRepo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import smith.rowe.ER;

public class Listeners implements ITestListener {
    ExtentReports extent = ER.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult r)
    {
       test=extent.createTest(r.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult r)
    {
        test.log(Status.PASS,"Dest Passed to Ac Milan");
    }

    @Override
    public void onTestFailure(ITestResult r)
    {
        test.log(Status.FAIL,"");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        //test.log(Status.PASS,"");
        extent.flush();
    }



}
