class shop {
    static PC buyPc() {
        def pc=new PC()
        pc.vendor = "Sunny"
        pc.clockRate = 2333
        pc.ram = 4096
        pc.os = "Linux"
        return pc
    }

}
