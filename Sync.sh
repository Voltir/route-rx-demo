#!/bin/bash

echo "Starting..."
mkdir /tmp/local_link_demo/
cp target/scala-2.11/example-fastopt.js /tmp/local_link_demo/
git checkout gh-pages
if [ $? -eq 0 ]; then
  mv /tmp/local_link_demo/* .
  echo "Syncing gh-pages"
  git commit -am "Sync to gh-pages"
  git push origin gh-pages
  rm -rf /tmp/local_link_demo/
  echo "Done"
else 
  echo "FAILED TO CHECKOUT GH-PAGES!"
fi
