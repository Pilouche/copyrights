package blockchain.copyrights;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Copyrights extends Contract {
    private static final String BINARY = "608060405260008054600160a060020a031916331790556105f1806100256000396000f3006080604052600436106100825763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b581146100875780634c953e611461009e5780634e3391fd146100a9578063712e7bf3146100b4578063949cd787146100cb5780639530feaf146100d6578063d0c48fe21461019d575b600080fd5b34801561009357600080fd5b5061009c6101b2565b005b61009c6004356101d5565b61009c60043561029a565b61009c600435600160a060020a036024351661030b565b61009c60043561032c565b3480156100e257600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261018b94369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375094975050600160a060020a0385358116965060208601351694604081013594506060013592506103f4915050565b60408051918252519081900360200190f35b3480156101a957600080fd5b5061009c6101d3565b600054600160a060020a03163314156101d357600054600160a060020a0316ff5b565b60008181526002602052604090206008015434146101f257600080fd5b600081815260026020526040808220600301549051600160a060020a03909116913480156108fc02929091818181858888f1935050505015801561023a573d6000803e3d6000fd5b506000908152600260209081526040808320600781018054600101905581518084018352338082528552600a9091019092529091209051815473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909116179055565b600034116102a757600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f193505050501580156102f1573d6000803e3d6000fd5b506000908152600260205260409020600401805434019055565b600082815260026020526040902060050154341461032857600080fd5b5050565b6000341161033957600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f19350505050158015610383573d6000803e3d6000fd5b50600090815260026020908152604080832060068101805460019081019091558251808401845233808252348287019081529087526009909301909452919093209151825473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039091161782559151910155565b600180548082019091556040805161010081018252888152602080820189905282518082018452600160a060020a03808a16825283850191909152835180850185529088168152600081830181905260608401919091526080830187905260a0830181905260c0830181905260e0830186905284815260028252929092208151805192939192610487928492019061052a565b5060208281015180516104a0926001850192019061052a565b5060408201515160028201805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03938416179091556060840151805160038501805490931693169290921790556020015160048201556080820151600582015560a0820151600682015560c0820151600782015560e0909101516008909101559695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061056b57805160ff1916838001178555610598565b82800160010185558215610598579182015b8281111561059857825182559160200191906001019061057d565b506105a49291506105a8565b5090565b6105c291905b808211156105a457600081556001016105ae565b905600a165627a7a72305820cb9641defc7f2e449a50f23db4c9b6c5e6e1548cc8e9435dd9fbe990166736ed0029";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_BUYCOPY = "buyCopy";

    public static final String FUNC_PRODUCTIONINVESTMENT = "productionInvestment";

    public static final String FUNC_SELLRIGHTS = "sellRights";

    public static final String FUNC_PRIVATEINVESTMENT = "privateInvestment";

    public static final String FUNC_NEWARTWORK = "newArtwork";

    public static final String FUNC_PAYSHARES = "payShares";

    protected Copyrights(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Copyrights(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> buyCopy(BigInteger artworkID, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYCOPY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(artworkID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> productionInvestment(BigInteger artworkID, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PRODUCTIONINVESTMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(artworkID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> sellRights(BigInteger artworkID, String producerAddr, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SELLRIGHTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(artworkID), 
                new org.web3j.abi.datatypes.Address(producerAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> privateInvestment(BigInteger artworkID, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PRIVATEINVESTMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(artworkID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> newArtwork(String name, String category, String artistAddr, String producerAddr, BigInteger worth, BigInteger fare) {
        final Function function = new Function(
                FUNC_NEWARTWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(category), 
                new org.web3j.abi.datatypes.Address(artistAddr), 
                new org.web3j.abi.datatypes.Address(producerAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(worth), 
                new org.web3j.abi.datatypes.generated.Uint256(fare)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> payShares() {
        final Function function = new Function(
                FUNC_PAYSHARES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Copyrights> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Copyrights.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Copyrights> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Copyrights.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Copyrights load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Copyrights(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Copyrights load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Copyrights(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}