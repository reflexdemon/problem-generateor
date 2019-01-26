#!/bin/bash


npm run build
TARGET=../../src/main/resources/static/

rm -rf $TARGET
mkdir $TARGET

cp -r ./dist/* $TARGET

tree $TARGET