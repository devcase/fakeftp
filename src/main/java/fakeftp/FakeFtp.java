package fakeftp;


import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

public class FakeFtp {

	public static void main(String[] args) {
		FakeFtpServer fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.addUserAccount(new UserAccount("user", "password", "/ALL_IN/"));

		FileSystem fileSystem = new UnixFakeFileSystem();
		fileSystem.add(new DirectoryEntry("/ALL_IN/"));
		fakeFtpServer.setFileSystem(fileSystem);

		fakeFtpServer.start();
		System.out.println("Fake FTP Server is running");
	}

}
