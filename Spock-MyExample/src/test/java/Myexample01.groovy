
import spock.lang.Specification

class Myexample01 extends Specification{
    // fields
    def stack = new Stack()
    // fixture methods
    def setupSepec(){}
    def setup(){
        assert stack.empty
    }
    def cleanup(){}
    def cleanupSpec(){}
    // feature methods
        // given when then
    def "pushing an element #elem on the stack #stack"(){
        given:

            def elem = "push me"
        when:
            stack.push(elem)
        then:
            !stack.empty
            stack.size() == 1
            stack.peek() == elem
    }
        // throw()
    def "poping an element #elem on the stack #stack"(){
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
        stack.empty
    }

    def "poping an element #elem on the stack #stack version2"(){
        when:
        stack.pop()
        then:
        def e=thrown(EmptyStackException)
        e.cause == null
    }
    def "poping an element #elem on the stack #stack version3"(){
        when:
        stack.pop()
        then:
        EmptyStackException e=thrown()
        e.cause == null
    }
    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()
        map.put(null, "elem")
    }
    def "HashMap accepts null key version2"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }
    def "collaborators must be invoked in order"() {
        def coll1 = Mock(Collaborator)
        def coll2 = Mock(Collaborator)

        when:
        // try to reverse the order of these invocations and see what happens
        coll1.collaborate()
        coll2.collaborate()

        then:
        1 * coll1.collaborate()

        then:
        1 * coll2.collaborate()
    }

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c
        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }
    // helper methods
    def "offered PC matches preferred configuration"() {
        when:
        def pc = shop.buyPc()
        then:
        pc.vendor == "Sunny"
        pc.clockRate >= 2333
        pc.ram >= 4096
        pc.os == "Linux"
    }
    def "offered PC matches preferred configuration version2"() {
        when:
        def pc = shop.buyPc()

        then:
        matchesPreferredConfiguration(pc)
    }

    def matchesPreferredConfiguration(pc) {
        pc.vendor == "Sunny"
                && pc.clockRate >= 2333
                && pc.ram >= 4096
                && pc.os == "Linux"
    }
    def matchesPreferredConfigurationversion2 (pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
        assert pc.ram >= 4096
        assert pc.os == "Linux"
    }

    def "offered PC matches preferred configuration version3"() {
        when:
        def pc = shop.buyPc()

        then:
        with(pc) {
            vendor == "Sunny"
            clockRate >= 2333
            ram >= 406
            os == "Linux"
        }
    }

    def "offered PC matches preferred configuration version4"() {
        when:
        def pc = shop.buyPc()

        then:
        verifyAll(pc) {
            vendor == "Sunny"
            clockRate >= 2333
            ram >= 406
            os == "Linux"
        }
    }
}
interface Collaborator {
    def collaborate()
}
