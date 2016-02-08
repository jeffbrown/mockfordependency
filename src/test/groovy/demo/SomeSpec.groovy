package demo

import groovy.mock.interceptor.MockFor
import spock.lang.Specification

class SomeSpec extends Specification {

	void 'test using MockFor'() {
		setup:
		def mock = new MockFor(Widget)
		mock.demand.getMagicNumber { ->
			2112
		}
		def result

		when:
		mock.use {
			result = new Widget().magicNumber
		}

		then:
		2112 == result
	}

}

class Widget {

	def getMagicNumber() {
		42
	}
}
