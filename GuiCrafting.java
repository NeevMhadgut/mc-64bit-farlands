import org.lwjgl.opengl.GL11;

public class GuiCrafting extends gb {
   public GuiCrafting(aak par1InventoryPlayer, World par2World, long par3, int par4, long par5) {
      super(new ContainerWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
   }

   public void e() {
      super.e();
   }

   protected void d() {
      this.u.b(cy.a("container.crafting"), 28, 6, 4210752);
      this.u.b(cy.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
   }

   protected void a(float par1, int par2, int par3) {
      int i = this.p.p.b("/gui/crafting.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.p.p.b(i);
      int j = (this.q - this.b) / 2;
      int k = (this.r - this.c) / 2;
      this.b(j, k, 0, 0, this.b, this.c);
   }
}
