#!/bin/sh
rm -r ./contracts/build
mkdir ./contracts/build
solc ./contracts/solidity/Contract.sol --bin --abi --optimize -o ./contracts/build/
web3j solidity generate ./contracts/build/copyrights.bin ./contracts/build/copyrights.abi -p blockchain.copyrights -o ./src/main/java/