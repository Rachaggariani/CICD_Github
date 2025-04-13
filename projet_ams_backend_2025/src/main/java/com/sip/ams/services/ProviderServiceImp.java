package com.sip.ams.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ProviderServiceImp implements ProviderService {
	private final Path root = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/uploads");
	private final ProviderRepository providerRepository;

	public ProviderServiceImp(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@Override
	public List<Provider> listProviders() {
		return (List<Provider>) this.providerRepository.findAll();
	}

	@Override
	public Provider getProvider(long id) {
		return this.providerRepository.findById(id).get();
	}

	/*@Override
	public Provider saveProvider(Provider provider) {
		return this.providerRepository.save(provider);
	}*/

	public Provider saveProvider(MultipartFile file,String name,String email,String address) {
		// generate new Random image name
				String newImageName = getSaltString().concat(file.getOriginalFilename());

				try {
					Files.copy(file.getInputStream(), this.root.resolve(newImageName)); // upload de l'image
				} catch (Exception e) {
					throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
				}

				Provider provider = new Provider(name, address, email, newImageName);

				providerRepository.save(provider);

				return provider;
		
		//return this.providerRepository.save(provider);
	}
	
	@Override
	public void deleteProvider(long id) {

		this.providerRepository.deleteById(id);

	}

	@Override
	public Optional<Provider> findProviderById(long id) {
		return this.providerRepository.findById(id);
	}
	
	// rundom string to be used to the image name
		protected static String getSaltString() {
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 18) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;

		}

}
