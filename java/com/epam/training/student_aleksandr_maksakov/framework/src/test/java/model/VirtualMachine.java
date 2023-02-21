package model;

import java.util.Objects;

public class VirtualMachine {

    private String numberOfInstances;
    private String oS;
    private String VMClass;
    private String series;
    private String instanceType;
    private String numberOfGPUs;
    private final String typeOfGPUs;
    private String sSD;
    private String databaseLocation;
    private String committedUsage;


    public VirtualMachine(String numberOfInstances, String oS, String VMClass, String series, String instanceType,
                          String typeOfGPUs, String numberOfGPUs, String sSD, String databaseLocation,
                          String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.oS = oS;
        this.VMClass = VMClass;
        this.series = series;
        this.instanceType = instanceType;
        this.typeOfGPUs = typeOfGPUs;
        this.numberOfGPUs = numberOfGPUs;
        this.sSD = sSD;
        this.databaseLocation = databaseLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOS() {
        return oS;
    }

    public void setOS(String oS) {
        this.oS = oS;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String Class) {
        this.VMClass = Class;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getTypeOfGPUs() {
        return typeOfGPUs;
    }

    public void setTypeGPUs(String gPUs) {
        this.numberOfGPUs = gPUs;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberGPUs(String gPUs) {
        this.numberOfGPUs = gPUs;
    }

    public String getSSD() {
        return sSD;
    }

    public void setSSD(String ssd) {
        this.sSD = ssd;
    }

    public String getDatabaseLocation() {
        return databaseLocation;
    }

    public void setDatabaseLocation(String databaseLocation) {
        this.databaseLocation = databaseLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "VM{" +
                "Number of instances='" + numberOfInstances + '\'' +
                ", OS='" + oS + '\'' +
                ", Class='" + VMClass + '\'' +
                ", Series='" + series + '\'' +
                ", Instance Type='" + instanceType + '\'' +
                ", Type of GPUs='" + typeOfGPUs + '\'' +
                ", Number of GPUs='" + numberOfGPUs + '\'' +
                ", SSD='" + sSD + '\'' +
                ", Database Location='" + databaseLocation + '\'' +
                ", Committed Usage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOS(), getVMClass());
    }
}
