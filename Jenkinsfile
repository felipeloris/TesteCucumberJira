#!groovy
@Library([
    'jenkins-shared-library',
    'jenkins-tests-library'
]) _

testApplicationPipelineCucumberJava([
    // enabled: false, // You can use the 'enabled' flag set to 'false' to disable this job completely.

    // schedule: '0 2 * * 4', // sheduled at 02:00 on Thursday.

    tool: "cucumber_java",

    abortOnMaxErrors: 0,    // Abort test execution if there are N errors. Set to zero (0) to execute until the end, no matter how many errors.

    jira: [
        testPlanKey: 'XD-25', // The testPlanKey is used to link the test executions and results to an Xray Test Plan issue.  We can use the same testPlanKey for all the configured suites, or a different testPlanKey for each suite. If this is defined at the 'suite' config level than it has precedence over the 'jira' config section.
        // url: 'https://m01.gateway.corp.xpto.pt/',
        // extraArgs: [ // Extra arguments that can be passed to the test integration command line.
        //     "arg1",
        //     "arg2"
        // ],
    ],

    vault: [
        name: 'tstfw',
        env: 'dev',
    ],

    suites: [
        "Regression Tests": [
            enabled: false, // You can use the 'enabled' flag set to 'false' to disable this suite, while executing any other enabled suite.
            tag: "@regression and not @ignore",
            // testPlanKey: 'XD-25', // The testPlanKey is used to link the test executions and results to an Xray Test Plan issue. If this is defined at the suite level than it has precedence over the 'jira' config section.
            // isParallel: true, // Use this to parallelize test execution and help reduce execution time.
        ],
        "Smoke Tests": [
            // enabled: false, // You can use the 'enabled' flag set to 'false' to disable this suite, while executing any other enabled suite.
            tag: "@smoke and not @ignore",
            testPlanKey: 'XD-25', // The testPlanKey is used to link the test executions and results to an Xray Test Plan issue. If this is defined at the suite level than it has precedence over the 'jira' config section.
            // isParallel: true, // Use this to parallelize test execution and help reduce execution time.
        ],
    ],
])
