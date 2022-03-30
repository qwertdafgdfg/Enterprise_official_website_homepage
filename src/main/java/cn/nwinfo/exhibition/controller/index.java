package cn.nwinfo.exhibition.controller;

import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.entity.*;
import cn.nwinfo.exhibition.service.*;
import cn.nwinfo.exhibition.util.PageRequest;
import cn.nwinfo.exhibition.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class index {
    @Autowired
    RotationChartService rotationChartService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ProductService productService;
    @Autowired
    AdvantageService advantageService;
    @Autowired
    AboutService aboutService;
    @Autowired
    ExampleService exampleService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ExampleCategoryService exampleCategoryService;

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    SeoSetupService seoSetupService;
    @Autowired
    LinkService linkService;
    @Autowired
    OtherImgService otherImgService;

    @PassToken
    @GetMapping(value = "/")
    public String index(Model model) {

        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);

        SeoSetup seo = seoSetupService.findById("5");
        model.addAttribute("seo", seo);

        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);

        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);

        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);


        List<RotationChart> pictures = rotationChartService.findByAll();
        model.addAttribute("pictures", pictures);

        List<Product> products = productService.findByHot();
        model.addAttribute("products", products);
        List<Advantage> advantages = advantageService.findByAll();
        model.addAttribute("advantages", advantages);
        List<About> aboutsHot = aboutService.findByHot();
        model.addAttribute("aboutsHot", aboutsHot);
        List<Example> examples = exampleService.findByHot();
        model.addAttribute("examples", examples);

        model.addAttribute("articles", articleService.findByHot());

        List<Link> links = linkService.findByAll();
        model.addAttribute("links", links);

        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);

        return "template_" + templates + "/index";
    }

    @PassToken
    @GetMapping("/index/about")
    public String about(Model model, String id) {
        //全部页面
        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);
        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);
        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);
        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);
        //全部页面
        model.addAttribute("advertisingMap", otherImgService.findById("4"));

        About about = aboutService.findById(id);
        model.addAttribute("about", about);
        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);
        return "template_" + templates + "/about";
    }

    @PassToken
    @GetMapping("/index/article")
    public String article(Model model, @RequestParam(required = false, defaultValue = "0") int id,
                          @RequestParam(required = false, defaultValue = "0") int categoryId) {
        //全部页面
        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);
        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);
        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);
        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);
        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);
        //全部页面
        SeoSetup seo = seoSetupService.findById("2");
        model.addAttribute("seo", seo);
        //seo
        model.addAttribute("advertisingMap", otherImgService.findById("3"));


        if (id > 0) {
            Article article = articleService.findById(id + "");
            article.setId(id + "");
            int clicks = Integer.parseInt(article.getClicks());
            clicks++;
            article.setClicks(clicks + "");
            articleService.updateById(article);
            model.addAttribute("article", article);
            return "template_" + templates + "/article";
        } else {
            model.addAttribute("categoryId", categoryId);
            return "template_" + templates + "/articleList";
        }

    }

    @PassToken
    @GetMapping("/index/product")
    public String product(Model model, @RequestParam(required = false, defaultValue = "0") int id,
                          @RequestParam(required = false, defaultValue = "0") int categoryId) {
        //全部页面
        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);
        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);
        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);
        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);
        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);
        //全部页面
        SeoSetup seo = seoSetupService.findById("4");
        model.addAttribute("seo", seo);
        //seo
        model.addAttribute("advertisingMap", otherImgService.findById("1"));


        if (id > 0) {
            Product product = productService.findById(id + "");
            product.setId(id + "");
            int clicks = Integer.parseInt(product.getClicks());
            clicks++;
            product.setClicks(clicks + "");
            productService.updateById(product);


            model.addAttribute("product", product);


            return "template_" + templates + "/product";
        } else {
            model.addAttribute("categoryId", categoryId);
            return "template_" + templates + "/productList";
        }

    }

    @PassToken
    @GetMapping("/index/example")
    public String example(Model model, @RequestParam(required = false, defaultValue = "0") int id,
                          @RequestParam(required = false, defaultValue = "0") int categoryId) {
        //全部页面
        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);
        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);
        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);
        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);
        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);
        //全部页面
        SeoSetup seo = seoSetupService.findById("3");
        model.addAttribute("seo", seo);
        //seo
        model.addAttribute("advertisingMap", otherImgService.findById("2"));


        if (id > 0) {
            Example example = exampleService.findById(id + "");
            example.setId(id + "");
            int clicks = Integer.parseInt(example.getClicks());
            clicks++;
            example.setClicks(clicks + "");
            exampleService.updateById(example);
            model.addAttribute("example", example);
            return "template_" + templates + "/example";
        } else {
            model.addAttribute("categoryId", categoryId);
            return "template_" + templates + "/exampleList";
        }

    }

    @PassToken
    @GetMapping("/index/messageBoard")
    public String messageBoard(Model model) {
        //全部页面
        Company company = companyService.findById("1");
        String templates = company.getTemplates();
        model.addAttribute("company", company);
        List<ProductCategory> productCategories = productCategoryService.findByAll();
        model.addAttribute("pCategories", productCategories);
        List<ExampleCategory> exampleCategories = exampleCategoryService.findByAll();
        model.addAttribute("eCategories", exampleCategories);
        List<ArticleCategory> articleCategories = articleCategoryService.findByAll();
        model.addAttribute("aCategories", articleCategories);
        List<About> abouts = aboutService.findByAll();
        model.addAttribute("abouts", abouts);
        //全部页面
        SeoSetup seo = seoSetupService.findById("1");
        model.addAttribute("seo", seo);
        //seo
        model.addAttribute("advertisingMap", otherImgService.findById("5"));


        return "template_" + templates + "/messageBoard";

    }

}
