package service;

import model.VirtualMachine;

public class VMCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.VM.NumberOfInstances";
    public static final String OS = "testdata.VM.OS";
    public static final String CLASS = "testdata.VM.Class";
    public static final String SERIES = "testdata.VM.Series";
    public static final String INSTANCE_TYPE = "testdata.VM.InstanceType";
    public static final String TYPE_OF_GPUS = "testdata.VM.TypeOfGPUs";
    public static final String NUMBER_OF_GPUS = "testdata.VM.NumberOfGPUs";
    public static final String SSD = "testdata.VM.SSD";
    public static final String DATABASE_LOCATION = "testdata.VM.DatabaseLocation";
    public static final String COMMITTED_USAGE = "testdata.VM.CommittedUsage";

    public static VirtualMachine withCredentialsFromProperty(){
        return new VirtualMachine(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OS),
                TestDataReader.getTestData(CLASS),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(TYPE_OF_GPUS),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(SSD),
                TestDataReader.getTestData(DATABASE_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }

    public static VirtualMachine withDefaultParameters(){
        return new VirtualMachine("1", "", "", "", "", "",
                "","", "", "");
    }
}