### Hexlet tests and linter status:
[![Actions Status](https://github.com/s-chepurnov/java-project-lvl2/workflows/hexlet-check/badge.svg)](https://github.com/s-chepurnov/java-project-lvl2/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/43d38a60c5a162503252/maintainability)](https://codeclimate.com/github/s-chepurnov/java-project-lvl2/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/43d38a60c5a162503252/test_coverage)](https://codeclimate.com/github/s-chepurnov/java-project-lvl2/test_coverage)

### Description

Find the difference between the two files. Supported formats: JSON, YAML.

[![asciicast](https://asciinema.org/a/475065.svg)](https://asciinema.org/a/475065)

### Run
```sh
make install
./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json
./build/install/app/bin/app -f plain src/test/resources/file1.yml src/test/resources/file2.yml
```
