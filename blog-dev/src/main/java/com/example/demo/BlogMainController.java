package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogMainController {
	@Autowired
	private BlogService blogService;

	/* サーバの/blogディレクトリをルートとする
	 * ルートにgetリクエストが来たらメインビュー"index"を返す
	 * blog/new にgetリクエストが来たら新規作成ビュー"new"を返す
	 * ルートにpostリクエストが来たら受けたモデルをDBに登録してページを更新させる
	 * {エントリid}/edit にpostリクエストが来たらDBのレコードを更新する
	 * {エントリid}/delete にpostリクエストが来たらそのidに合致するレコードをDBから削除する
	 */
	@GetMapping
	public String index(Model model) {
		List<BlogEntry> entries = blogService.findAll();
		model.addAttribute("entries", entries);
		return "index";
	}

	@GetMapping("new")
	public String newEntry(Model model) {
		return "new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {
		BlogEntry entry = blogService.findOne(id);
		model.addAttribute("entry", entry);
		return "edit";
	}

	@PostMapping
	public String create(@ModelAttribute BlogEntry entry) {
		blogService.register(entry);
		return "redirect:/blog";
	}

	@PostMapping("{id}/edit")
	public String edit(@PathVariable Integer id, @ModelAttribute BlogEntry entry) {
		entry.setId(id);
		blogService.update(entry);
		return "redirect:/blog";
	}

	@PostMapping("{id}/delete")
	public String destroy(@PathVariable Integer id) {
		blogService.delete(id);
		return "redirect:/blog";
	}
}
