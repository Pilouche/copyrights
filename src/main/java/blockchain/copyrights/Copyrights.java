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
import org.web3j.tuples.generated.Tuple9;
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
    private static final String BINARY = "608060405260008054600160a060020a03191633179055610c7f806100256000396000f3006080604052600436106100985763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663167ddf6e811461009d57806341c0e1b5146102a65780634c953e61146102bd5780634e3391fd146102c8578063712e7bf3146102d3578063949cd787146102ea578063c52658da146102f5578063d0c48fe21461031c578063fbbc674414610331575b600080fd5b3480156100a957600080fd5b506100b560043561046b565b6040518080602001806020018a600160a060020a0316600160a060020a031681526020018060200189600160a060020a0316600160a060020a031681526020018060200188815260200187815260200186815260200185810385528e818151815260200191508051906020019080838360005b83811015610140578181015183820152602001610128565b50505050905090810190601f16801561016d5780820380516001836020036101000a031916815260200191505b5085810384528d5181528d516020918201918f019080838360005b838110156101a0578181015183820152602001610188565b50505050905090810190601f1680156101cd5780820380516001836020036101000a031916815260200191505b5085810383528b5181528b516020918201918d019080838360005b838110156102005781810151838201526020016101e8565b50505050905090810190601f16801561022d5780820380516001836020036101000a031916815260200191505b5085810382528951815289516020918201918b019080838360005b83811015610260578181015183820152602001610248565b50505050905090810190601f16801561028d5780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390f35b3480156102b257600080fd5b506102bb610720565b005b6102bb600435610743565b6102bb600435610882565b6102bb600435600160a060020a03602435166108f3565b6102bb600435610914565b34801561030157600080fd5b5061030a610a3f565b60408051918252519081900360200190f35b34801561032857600080fd5b506102bb610741565b34801561033d57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261030a94369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f818a01358b0180359182018390048302840183018552818452989b600160a060020a038b35169b909a90999401975091955091820193509150819084018382808284375050604080516020601f818a01358b0180359182018390048302840183018552818452989b600160a060020a038b35169b909a909994019750919550918201935091508190840183828082843750949750508435955050506020909201359150610a469050565b60008181526002602081815260408084208084015460048201546006830154600784015460088501548554875161010060018084161591909102600019019092169a909a04601f81018a90048a028b018a01909852878a5260609a8b9a90998b998b998b998b998a998a9993988998890197600160a060020a039485169760038b0197959094169560058b0195939490938b9183018282801561054f5780601f106105245761010080835404028352916020019161054f565b820191906000526020600020905b81548152906001019060200180831161053257829003601f168201915b50508b5460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959e508d9450925084019050828280156105dd5780601f106105b2576101008083540402835291602001916105dd565b820191906000526020600020905b8154815290600101906020018083116105c057829003601f168201915b5050895460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959d508b94509250840190508282801561066b5780601f106106405761010080835404028352916020019161066b565b820191906000526020600020905b81548152906001019060200180831161064e57829003601f168201915b5050875460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959b50899450925084019050828280156106f95780601f106106ce576101008083540402835291602001916106f9565b820191906000526020600020905b8154815290600101906020018083116106dc57829003601f168201915b50505050509350995099509950995099509950995099509950509193959799909294969850565b600054600160a060020a031633141561074157600054600160a060020a0316ff5b565b6000818152600260209081526040808320338452600a0190915290205474010000000000000000000000000000000000000000900460ff161561078557600080fd5b60008181526002602052604090206008015434146107a257600080fd5b600081815260026020526040808220600401549051600160a060020a03909116913480156108fc02929091818181858888f193505050501580156107ea573d6000803e3d6000fd5b506040805180820182523380825260016020808401918252600095865260028152848620928652600a909201909152919092209151825491511515740100000000000000000000000000000000000000000274ff000000000000000000000000000000000000000019600160a060020a039290921673ffffffffffffffffffffffffffffffffffffffff199093169290921716179055565b6000341161088f57600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f193505050501580156108d9573d6000803e3d6000fd5b506000908152600260205260409020600601805434019055565b600082815260026020526040902060070154341461091057600080fd5b5050565b6000341161092157600080fd5b6000818152600260208190526040808320909101549051600160a060020a03909116913480156108fc02929091818181858888f1935050505015801561096b573d6000803e3d6000fd5b506000818152600260208181526040808420338552600901909152909120015460ff161515610a165760408051606081018252338082523460208084019182526001848601818152600088815260028085528882209682526009909601909352959091209351845473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0390911617845590519083015591519101805460ff1916911515919091179055610a3c565b600081815260026020908152604080832033845260090190915290206001018054340190555b50565b6001545b90565b600180548082019091556040805160c0810182528a815260208082018b905282518084018452600160a060020a03808c1682528183018b905283850191909152835160608181018652918a1681528083018990526000818601819052918401526080830187905260a0830186905284815260028252929092208151805192939192610ad49284920190610bbb565b506020828101518051610aed9260018501920190610bbb565b506040820151805160028301805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911781556020808301518051610b3b9260038701920190610bbb565b5050506060820151805160048301805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911781556020808301518051610b8b9260058701920190610bbb565b506040820151816002015550506080820151816007015560a0820151816008015590505098975050505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610bfc57805160ff1916838001178555610c29565b82800160010185558215610c29579182015b82811115610c29578251825591602001919060010190610c0e565b50610c35929150610c39565b5090565b610a4391905b80821115610c355760008155600101610c3f5600a165627a7a723058209b605a9d6164745e3311b056a55d71c8dd563296357bd8b28c1ded7bb8f735990029";

    public static final String FUNC_GETARTWORK = "getArtwork";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_BUYCOPY = "buyCopy";

    public static final String FUNC_PRODUCTIONINVESTMENT = "productionInvestment";

    public static final String FUNC_SELLRIGHTS = "sellRights";

    public static final String FUNC_PRIVATEINVESTMENT = "privateInvestment";

    public static final String FUNC_GETARTWORKSCOUNT = "getArtworksCount";

    public static final String FUNC_PAYSHARES = "payShares";

    public static final String FUNC_NEWARTWORK = "newArtwork";

    protected Copyrights(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Copyrights(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple9<String, String, String, String, String, String, BigInteger, BigInteger, BigInteger>> getArtwork(BigInteger index) {
        final Function function = new Function(FUNC_GETARTWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple9<String, String, String, String, String, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple9<String, String, String, String, String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple9<String, String, String, String, String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<String, String, String, String, String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue());
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

    public RemoteCall<BigInteger> getArtworksCount() {
        final Function function = new Function(FUNC_GETARTWORKSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> payShares() {
        final Function function = new Function(
                FUNC_PAYSHARES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newArtwork(String name, String category, String artistAddr, String artistName, String producerAddr, String producerName, BigInteger worth, BigInteger fare) {
        final Function function = new Function(
                FUNC_NEWARTWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(category), 
                new org.web3j.abi.datatypes.Address(artistAddr), 
                new org.web3j.abi.datatypes.Utf8String(artistName), 
                new org.web3j.abi.datatypes.Address(producerAddr), 
                new org.web3j.abi.datatypes.Utf8String(producerName), 
                new org.web3j.abi.datatypes.generated.Uint256(worth), 
                new org.web3j.abi.datatypes.generated.Uint256(fare)), 
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
