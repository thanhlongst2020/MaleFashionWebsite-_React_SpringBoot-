package com.malefashionshop.controller;

import com.malefashionshop.dto.request.ProductImageUpdateDto;
import com.malefashionshop.dto.response.ProductImageResponseDto;
import com.malefashionshop.dto.response.UploadImageResponseDto;
import com.malefashionshop.entities.ProductImageEntity;
import com.malefashionshop.service.impl.ImagesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/images")
public class ProductImageController {
    @Autowired
    ImagesStorageService imagesStorageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UploadImageResponseDto> uploadFiles(@RequestParam(name = "productID", required = false) Long productID,
                                                              @RequestParam("files") MultipartFile[] files) {
        return imagesStorageService.saveImages(files, productID);
    }

//    @PostMapping("/uploadOne")
//    public ProductImageResponseDto uploadOneFile(@RequestParam(name = "productID") Long productID,
//                                                              @RequestParam("file") File file) {
//        return imagesStorageService.saveOneImage(file, productID);
//    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductImageResponseDto>> getListFiles(@PathVariable Long productId) {
        return imagesStorageService.loadAllByProductID(productId);
    }

    @PutMapping("/{productImageID}")
    public ResponseEntity<ProductImageResponseDto> updateImages(@PathVariable("productImageID") Long productImageID, @RequestBody ProductImageUpdateDto productImageUpdateDto){
        return this.imagesStorageService.updateImages(productImageID, productImageUpdateDto);
    }

//    @GetMapping("/files/{filename:.+}")
//    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
//        Resource file = imagesStorageService.load(filename);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }

//    @PostMapping("/upload-files")
//    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//
//        String Path_Directtory = "E:\\Cong_Viec\\2022-2023\\NashTech\\The Rookies\\Individual Project\\MaleFashionWebsite_React_SpringBoot\\BackEnd-SpringBoot\\src\\main\\resources\\images\\productImages";
//        Files.copy(file.getInputStream(), Paths.get(Path_Directtory + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//
//        return "Successful";
//    }
}
