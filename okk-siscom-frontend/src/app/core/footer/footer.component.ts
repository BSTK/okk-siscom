import {Component} from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `
    <div class="container">
      <footer class="pt-3 mt-4 text-body-secondary border-top">
        &copy; {{ ano() }}
      </footer>
    </div>
  `
})
export class FooterComponent {

  protected ano(): number {
    return new Date().getFullYear();
  }
}
