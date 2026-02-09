### Project Title
Automating ReadyAPI tests with a Java framework

### What It Is
This is a Java-based test automation project that runs SOAP/REST API tests using ReadyAPI within a structured Java framework. It includes test runner configs, a TestNG suite, Docker Compose for infra, and CI support.

### Tech Used
Java
ReadyAPI / SoapUI tests
TestNG
Docker / Docker Compose
Jenkins for CI

### What It Does
Launches the test stack, executes API tests defined in ReadyAPI via a Java framework, and produces reports.

### How to Run

### Clone the project
git clone https://github.com/AshikaSridhar26/soapUIJavaTest

cd soapUIJavaTest

### Start required services
docker compose up -d
(This starts any services defined in docker-compose.yml needed by the tests)

### Run tests
This will start containers defined in docker-compose.yml (services your tests depend on such as databases or API mocks).

### Build the test runner:
docker build -t soapuijava-test .

### Run the tests through Docker (if a Dockerfile exists):
docker run --rm --network host soapuijava-test
### View results
Test reports and logs are available under the configured output folder after execution.

### CI
Jenkinsfile is included for automated pipelines.

### Notes
Edit environment or endpoint configurations in the Java framework or ReadyAPI project if needed before running.
Ensure ReadyAPI is installed or the test execution environment can launch ReadyAPI tests from Java.
