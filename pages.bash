#!/bin/bash
# this script generates the gh-pages branch after build in circleci
# ${project.build.finalName}

# exit on error
set -e

cd "$(dirname "$0")"
git init

# create index file
cat >index.md <<EOL
## ${project.build.finalName} build $CIRCLE_BUILD_NUM

$(git log -1 | sed 's/^/    /')

### Docs

* [Javadoc online](apidocs/)
* [${project.build.finalName}-javadoc.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-javadoc.jar)
* [${project.build.finalName}-sources.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-sources.jar)


### Jars

* [${project.build.finalName}-standalone.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-standalone.jar)
* [${project.build.finalName}-standalone-full.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-standalone-full.jar)
* [${project.build.finalName}.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}.jar)

EOL

# push
git add apidocs
git add index.md
git -c "user.name=CircleCI" -c "user.email=mingwei.samuel@gmail.com" commit -m "autogen javadoc [ci skip]"
git push -f https://github.com/MingweiSamuel/Zyra.git HEAD:gh-pages
