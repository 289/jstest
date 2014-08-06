package ProxyPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/6
 * Time: 22:39
 * Definition
 * Provide a surrogate or placeholder for another object to control access to it.
 */
public class Client {
	public static void main(String[] args){
		Subject subject=new ProxySubject(new RealSubject());
		subject.request();
	}
}

/**
 * Proxy
		 maintains a reference that lets the proxy access the real subject. Proxy may refer to a Subject if the RealSubject and Subject interfaces are the same.
		 provides an interface identical to Subject's so that a proxy can be substituted for for the real subject.
		 controls access to the real subject and may be responsible for creating and deleting it.

 		other responsibilites depend on the kind of proxy:
			 remote proxies are responsible for encoding a request and its arguments and for sending the encoded request to the real subject in a different address space.
			 virtual proxies may cache additional information about the real subject so that they can postpone accessing it. For example, the ImageProxy from the Motivation caches the real images's extent.
			 protection proxies check that the caller has the access permissions required to perform a request.
			 Subject
			 defines the common interface for RealSubject and Proxy so that a Proxy can be used anywhere a RealSubject is expected.
			 RealSubject
			 defines the real object that the proxy represents.

 Types of Proxies
 1.  Remote Proxy - Provides a reference to an object located in a different
 	address space on the same or different machine
 2.  Virtual Proxy - Allows the creation of a memory intensive object on
 	demand. The object will not be created until it is really needed.
 3.  Copy-On-Write Proxy - Defers copying (cloning) a target object until
 	required by client actions. Really a form of virtual proxy.
 4.  Protection (Access) Proxy - Provides different clients with different levels
 	of access to a target object
 5.  Cache Proxy - Provides temporary storage of the results of expensive target
 	operations so that multiple clients can share the results
 6.  Firewall Proxy - Protects targets from bad clients (or vice versa)
 7.  Synchronization Proxy - Provides multiple accesses to a target object
 8.  Smart Reference Proxy - Provides additional actions whenever a target
 	object is referenced such as counting the number of references to the object
 */
