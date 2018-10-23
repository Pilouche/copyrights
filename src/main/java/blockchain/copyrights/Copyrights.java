package blockchain.copyrights;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
    private static final String BINARY = "608060405260008054600160a060020a03191633179055610977806100256000396000f30060806040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663167ddf6e811461009257806341c0e1b5146101cf5780634c953e61146101e65780634e3391fd146101f1578063712e7bf3146101fc578063949cd787146102135780639530feaf1461021e578063d0c48fe2146102e5575b600080fd5b34801561009e57600080fd5b506100aa6004356102fa565b60405180806020018060200188600160a060020a0316600160a060020a0316815260200187600160a060020a0316600160a060020a0316815260200186815260200185815260200184815260200183810383528a818151815260200191508051906020019080838360005b8381101561012d578181015183820152602001610115565b50505050905090810190601f16801561015a5780820380516001836020036101000a031916815260200191505b5083810382528951815289516020918201918b019080838360005b8381101561018d578181015183820152602001610175565b50505050905090810190601f1680156101ba5780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b3480156101db57600080fd5b506101e461047e565b005b6101e46004356104a1565b6101e46004356105e0565b6101e4600435600160a060020a0360243516610651565b6101e4600435610672565b34801561022a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102d394369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375094975050600160a060020a03853581169650602086013516946040810135945060600135925061079d915050565b60408051918252519081900360200190f35b3480156102f157600080fd5b506101e461049f565b60008181526002602081815260408084208084015460038201546004830154600584015460068501548554875161010060018084161591909102600019019092169a909a04601f81018a90048a028b018a01909852878a5260609a8b9a90998a998a998a998a99919895890197600160a060020a03918216979190921695949193909289918301828280156103d05780601f106103a5576101008083540402835291602001916103d0565b820191906000526020600020905b8154815290600101906020018083116103b357829003601f168201915b5050895460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959c508b94509250840190508282801561045e5780601f106104335761010080835404028352916020019161045e565b820191906000526020600020905b81548152906001019060200180831161044157829003601f168201915b505050505095509650965096509650965096509650919395979092949650565b600054600160a060020a031633141561049f57600054600160a060020a0316ff5b565b600081815260026020908152604080832033845260080190915290205474010000000000000000000000000000000000000000900460ff16156104e357600080fd5b600081815260026020526040902060060154341461050057600080fd5b600081815260026020526040808220600301549051600160a060020a03909116913480156108fc02929091818181858888f19350505050158015610548573d6000803e3d6000fd5b5060408051808201825233808252600160208084019182526000958652600281528486209286526008909201909152919092209151825491511515740100000000000000000000000000000000000000000274ff000000000000000000000000000000000000000019600160a060020a039290921673ffffffffffffffffffffffffffffffffffffffff199093169290921716179055565b600034116105ed57600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f19350505050158015610637573d6000803e3d6000fd5b506000908152600260205260409020600401805434019055565b600082815260026020526040902060050154341461066e57600080fd5b5050565b6000341161067f57600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f193505050501580156106c9573d6000803e3d6000fd5b506000818152600260208181526040808420338552600701909152909120015460ff1615156107745760408051606081018252338082523460208084019182526001848601818152600088815260028085528882209682526007909601909352959091209351845473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0390911617845590519083015591519101805460ff191691151591909117905561079a565b600081815260026020908152604080832033845260070190915290206001018054340190555b50565b600180548082019091556040805160c081018252888152602080820189905282518082018452600160a060020a03808a16825283850191909152835180850185529088168152600081830181905260608401919091526080830187905260a083018690528481526002825292909220815180519293919261082192849201906108b0565b50602082810151805161083a92600185019201906108b0565b5060408201515160028201805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03938416179091556060840151805160038501805490931693169290921790556020015160048201556080820151600582015560a0909101516006909101559695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106108f157805160ff191683800117855561091e565b8280016001018555821561091e579182015b8281111561091e578251825591602001919060010190610903565b5061092a92915061092e565b5090565b61094891905b8082111561092a5760008155600101610934565b905600a165627a7a72305820ca8d2eebbdac59c26e5be9f3c6b84aacacf5eff2002ef5830ec09a9759c55f3a0029";

    public static final String FUNC_GETARTWORK = "getArtwork";

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

    public RemoteCall<Tuple7<String, String, String, String, BigInteger, BigInteger, BigInteger>> getArtwork(BigInteger index) {
        final Function function = new Function(FUNC_GETARTWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<String, String, String, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple7<String, String, String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
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
